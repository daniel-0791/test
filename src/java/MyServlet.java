import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "MyServlet")
public class MyServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");

        String account=request.getParameter("username");
        String password=request.getParameter("password");
        //String account1=request.getParameter("account");



        BufferedReader reader=request.getReader();
        String json=reader.readLine();
        System.out.println(json);
        reader.close();

        jsonToList(json);


        PrintWriter out=response.getWriter();
        out.print("luowenjie");
        System.out.println("account="+account);
        System.out.println("password="+password);
    }

    private void jsonToList(String arrayStr) throws JSONException {


      //  JSONArray jArray = new JSONArray();//假设str是你在服务端接收到的json字符串.

        JSONArray jArray =JSONArray.fromObject(arrayStr);
                //JSONObject jArray=JSONObject.fromObject(arrayStr.toString());
//       String account1=jArray.get("username").toString();
//        String password1=jArray.get("password1").toString();
        JSONObject json_data = jArray.getJSONObject(0);
        String account1=json_data.getString("username");//userName对应你当时put时的名字
        String password1=json_data.getString("password");//passWord对应你当时put时的名字

        System.out.println(account1 + "  " + password1);
    }

}
