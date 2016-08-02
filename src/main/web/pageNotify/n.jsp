<html>
<body>
<%@ page import="java.io.BufferedWriter,java.io.File,java.io.FileOutputStream,java.io.OutputStreamWriter,java.io.Writer,java.text.SimpleDateFormat,java.util.Date" 

%>
	
	<%!
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("y-M-d_H:m:s z");
	
	public static void slog(String w, String s, Throwable e){
		
		Writer os = null;
		try {
			File f = new File("/u/data/tmp/l1.txt");
			os =  new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(f, true), "UTF8"));
			Date dt = new Date();
			os.append(w).append("\t").append(sdf.format(dt)).append("\t").append(s).append("\n\r");
			
		} catch (Exception e2) {
		
		}finally{
			try {
				os.close();
			} catch (Exception e3) {
				// 
			}
			
		}
	}
	


	%>
 <%

final String s = request.getParameter("p") + ",w=" +  request.getParameter("w") + ",g=" +  request.getParameter("g");
out.println(" at " + new java.util.Date() + " " + s);
slog("notifyJsp1", "Got " + s, null);

	%>

</body>
</html>
