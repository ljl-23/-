package src.com.System.listener;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener()
public class CssUserCountListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //session创建后会调用
        System.out.println("sessionCreated");
        //统计信息ServletContext
        ServletContext context = se.getSession().getServletContext();
        //人数 servletContexrz中取(原来Object,所有要强制转换)
        Integer count = (Integer) context.getAttribute("count");
        if(count ==null){
            count = 0;
        }else {
            count++;
        }
        context.setAttribute("count",count);
    }
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        //session销毁会调用
        System.out.println("sessionCreate");
        ServletContext context = se.getSession().getServletContext();
        //取出数据
        Integer count = (Integer) context.getAttribute("count");
        count--;
        context.setAttribute("count",count);
    }
 /*   @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        //当属性添加之后触发
        //将用户信息保存到servletcontext
        String attrName= se.getName();//添加的属性名 username

        if(attrName.equals("username")){

            String username= (String) se.getValue();//获取添加的属性值
            //将用户信息保存
            UserCount userc = new UserCount(username);
            HttpSession session = se.getSession();
            ServletContext context =session.getServletContext();
            Map<String, UserCount> userMap = (Map<String,UserCount>)context.getAttribute("users");
            if(userMap==null){
                userMap = new HashMap<>();
            }
            userMap.put(session.getId(),userc);
            context.setAttribute("users",userMap);
        }
    }
    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        //当属性删除之后触发
        //将用户信息保存到servletcontext
        String attrName= se.getName();//删除的属性名 username

        if(attrName.equals("username")){

            HttpSession session = se.getSession();
            ServletContext context =session.getServletContext();
            Map<String,UserCount> userMap = (Map<String,UserCount>)context.getAttribute("users");
            userMap.remove(session.getId());
            context.setAttribute("users",userMap);
        }
    }
*/

}
