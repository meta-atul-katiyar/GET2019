import java.io.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.util.regex.*;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/uploadImage")
public class uploadProfilePicture extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		System.out.println("request: " + request);
		if (!isMultipart) {
			System.out.println("File Not Uploaded");
		} else {

			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List items = null;

			try {
				items = upload.parseRequest(request);
				System.out.println("items: " + items);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			Iterator itr = items.iterator();
			String value = null;
			while (itr.hasNext()) {
				
				FileItem item = (FileItem) itr.next();
				if (item.isFormField()) {
					String name = item.getFieldName();
					System.out.println("name: " + name);
					value = item.getString();
					//System.out.println("value: " + value);
				} else {
					System.out.println("value: " + value);
					try {
						String itemName = item.getName();
						Random generator = new Random();
						int r = Math.abs(generator.nextInt());

						String reg = "[.*]";
						String replacingtext = "";
						System.out.println("Text before replacing is:-"
								+ itemName);
						Pattern pattern = Pattern.compile(reg);
						Matcher matcher = pattern.matcher(itemName);
						StringBuffer buffer = new StringBuffer();

						while (matcher.find()) {
							matcher.replaceAll(replacingtext);
						}

						// delete previous image
						DBConnection dbConn = new DBConnection();

						String query = "SELECT * FROM `EAD-4`.`profile` AS P"
								+ " WHERE P.employeeId='" + value + "';";
						PreparedStatement st = dbConn.estabConn(query);

						ResultSet rs = st.executeQuery();
						rs.next();
						
						boolean erased=false;
						
						if (rs.getRow() > 0) {
							String imageName = rs.getString("image");
							File storeFile = new File(
									"C:/Users/Atul/Documents/EAD-4/WebContent/images\\"
											+ imageName);
							// deletes the file on disk
							erased = storeFile.delete();
						}

						int IndexOf = itemName.indexOf(".");
						String domainName = itemName.substring(IndexOf);
						System.out.println("domainName: " + domainName);

						String finalimage = buffer.toString() + "_" + r
								+ domainName;
						System.out.println("Final Image===" + finalimage);

						File savedFile = new File(
								"C:/Users/Atul/Documents/EAD-4/WebContent/images\\"
										+ finalimage);
						item.write(savedFile);


						// enter in db
						String queryStoreImage = null;
						if(erased==false){
						queryStoreImage = "INSERT INTO `EAD-4`.`profile`"
								+ " (image, employeeId, timeOfUpload)"
								+ " values(?, ? , now())";
						}
						else{
							queryStoreImage = "UPDATE `EAD-4`.`profile` AS P"
									+ " SET P.image=?, P.employeeId=?, "
									+"timeOfUpload=now()"
									+" WHERE P.employeeId="+value;
						}
						PreparedStatement st1 = dbConn
								.estabConn(queryStoreImage);

						st1.setString(1, finalimage);
						st1.setInt(2, Integer.parseInt(value));

						// Execute the insert command using executeUpdate()
						// to make changes in database
						st1.executeUpdate();

						// Close all the connections
						st.close();
						st1.close();
						dbConn.closeConnection();

						out.println("<html>");
						out.println("<body>");
						out.println("<table><tr>" + finalimage + "<td>");
						out.println("<img src=/EAD/images/" + finalimage + "/>");
						out.println("</td></tr></table>");

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
