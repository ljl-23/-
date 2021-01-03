package src.com.System.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.beanutils.BeanUtils;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
//连接数据库进行操作
public class DBUtils {
    public static Connection getConnection() throws Exception {
        // jdbc数据库操作 读取配置文件
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties");
        Properties properties =new Properties();
        properties.load(in);

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        return dataSource.getConnection();
    }

    //类型参数，类型变量，类型是可以变化 Teacher Student
    public static <T> List<T> getList(Class<T> clazz, String sql, Object... args)  {
        Connection conn = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        List<T> userList =null;
        try {

            conn = DBUtils.getConnection();
            //String sql="select id,name,birthday from users where id = ? and username =?";
            ps = conn.prepareStatement(sql);

            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            rs = ps.executeQuery();
            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取当前结果集的列数
            int colnum = rsmd.getColumnCount();

            userList = new ArrayList<T>();

            while (rs.next()) {

                //key存放列名   ，value存放列值，for循环完成之后，rowMap存放一条记录
                Map<String, Object> rowMap = new HashMap<String, Object>();
                for (int i = 1; i <= colnum; i++) {
                    String columnName = rsmd.getColumnLabel(i);
                    Object columnValue = rs.getObject(columnName);
                    //判断查询出来的类的类型，如果是java.sql.Data转成java.util.Data
                    if (columnValue instanceof java.sql.Date) {
                        java.sql.Date data = (java.sql.Date) columnValue;
                        columnValue = new  java.sql.Date(data.getTime());
                    }
                    rowMap.put(columnName, columnValue);
                }
                //创建一个User对象，给这个User对象属性赋值
                T bean = clazz.newInstance();
                //  根据列名， id  == 给User对象id属性赋值的方法名，setId ,"set"+Id=setId,调用setId方法给user对象赋值，map中的value

                //循环rowMap给User所有属性赋值  entry{key,value} [{id:1},{username:"king",{"birthday:2020-10-14"}}]
                for (Map.Entry<String, Object> entry : rowMap.entrySet()) {
                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();
                    BeanUtils.setProperty(bean, propertyName, propertyValue);

                }
                //封装user对象
                userList.add(bean);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, rs);
        }
        return userList;
    }
    public static void close(Connection conn, Statement ps, ResultSet rs) {
        if(rs !=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps !=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn !=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //保存对象方法
    public static boolean save( String sql, Object... args)  {

        Connection conn = null;
        PreparedStatement ps=null;
        Integer count= null;

        try {
            //获取数据库连接对象
            conn = DBUtils.getConnection();
            //预编译SQL语句
            ps = conn.prepareStatement(sql);

            //给占位符赋值
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            //返回更新的记录数
            count = ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps,null);
        }

        return count!=null && count>0 ? true:false;
    }

    //类型参数，类型变量，类型是可以变化 Teacher Student  [Class<T> 字节码文件，T变化的类型。]
    public static <T> T getSingleObj(Class<T> clazz, String sql, Object... args)  {

        Connection conn = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        T bean =null;
        try {
            //获取数据库连接对象
            conn = DBUtils.getConnection();
            //预编译SQL语句
            ps = conn.prepareStatement(sql);

            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            rs = ps.executeQuery();
            //获取结果集元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取当前结果集的列数
            int colnum = rsmd.getColumnCount();

            while (rs.next()) {

                //key存放列名   ，value存放列值，for循环完成之后，rowMap存放一条记录
                Map<String, Object> rowMap = new HashMap<String, Object>();
                for (int i = 1; i <=colnum; i++) {
                    String columnName = rsmd.getColumnLabel(i);
                    Object columnValue = rs.getObject(columnName);
                    //判断查询出来的类的类型，如果是java.sql.Data转成java.util.Data
                    if (columnValue instanceof java.sql.Date) {
                        java.sql.Date data = (java.sql.Date) columnValue;
                        columnValue = new java.util.Date(data.getTime());
                    }

                    rowMap.put(columnName, columnValue);
                }
                //创建一个User对象，给这个User对象属性赋值
                bean = clazz.newInstance();
                // userClass  User.class的字节码文件
//            Class<User> clazz = User.class;
                //  根据列名， id  == 给User对象id属性赋值的方法名，setId ,"set"+Id=setId,调用setId方法给user对象赋值，map中的value

                //循环rowMap给User所有属性赋值  entry{key,value} [{id:1},{username:"king",{"birthday:2020-10-14"}}]
                for (Map.Entry<String, Object> entry : rowMap.entrySet()) {
                    String propertyName = entry.getKey();
                    Object propertyValue = entry.getValue();
                    BeanUtils.setProperty(bean,propertyName,propertyValue);
                    /*//获取propertyName属性赋值的set方法
                    String methodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);

                    //对象获取自己对应的字节码文件
                    Method method = clazz.getMethod(methodName, propertyValue.getClass());

                    //调用方法给属性赋值
                    method.invoke(bean, propertyValue);*/
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, rs);
        }
        return bean;
    }
    //查询记录数量
    public static Integer getCount(String sql, Object... args) {

        Connection conn = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        Integer count =null;
        try {
            //获取数据库连接对象
            conn = DBUtils.getConnection();
            //预编译SOL语句
            ps = conn.prepareStatement(sql);
            //如果有条件参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    ps.setObject(i + 1, args[i]);
                }
            }
            //执行查询，获取结果集
            rs = ps.executeQuery();

            while (rs.next()) {

                count = rs.getInt(1);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps, rs);
        }
        return count;
    }
    //更新操作
    public static boolean update (String sql, Object... args)  {
        Connection conn = null;
        PreparedStatement ps=null;
        Integer count = 0;
        try {
            // 获取数据库连接对象
            conn = DBUtils.getConnection();
            //预编译SOL语句
            ps = conn.prepareStatement(sql);
            //如果有条件参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {

                    //判断当前数据类型，是不是java.util.Date,转换成为java.sql.Date
                    if(args[i] instanceof java.util.Date){
                        java.util.Date date = (java.util.Date)args[i];
                        //转换成java.sql.Date
                        args[i] = new java.sql.Date(date.getTime());
                    }
                    ps.setObject(i + 1, args[i]);
                }
            }
            count = ps.executeUpdate();

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            close(conn, ps,null);
        }

        return count>0?true:false;
    }
    //更新操作同时得到主键
    public static Integer updateForPrimary(String sql, Object... args)  {
        Connection conn = null;
        PreparedStatement ps = null;
        Integer primaryKey = null;
        ResultSet rs = null;
        try {
            // 获取数据库连接对象
            conn = DBUtils.getConnection();
            // 预编译SQL语句
            ps = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            // 如果有条件参数
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; ++i) {

                    // 判断当前类型，是不是java.util.Date，转换成java.sql.Date
                    if(args[i] instanceof java.util.Date){
                        java.util.Date date = (java.util.Date)args[i];
                        // 转换成java.sql.Date
                        args[i] = new java.sql.Date(date.getTime());
                    }

                    ps.setObject(i + 1, args[i]);
                }
            }
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();

            if(rs.next()){
                primaryKey = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, rs);
        }
        return primaryKey;
    }
    public static void update1(String sql) {
        Connection conn = null;
        try{
            conn = DBUtils.getConnection();
            conn.createStatement().executeUpdate(sql);
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
