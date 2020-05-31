import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.util.HashSet;
import java.util.LinkedList;
public class Crawler {
	static final String HREF_TAG = "<a href=\"http";
	static LinkedList<URLDepthPair> allSitesSeen = new LinkedList<URLDepthPair>();
	static LinkedList<URLDepthPair> toVisit = new LinkedList<URLDepthPair>();
	public static void crawl(String startURL, int maxDepth)
			throws MalformedURLException {
		URLDepthPair urlPair = new URLDepthPair(startURL, 0);
		toVisit.add(urlPair);
		int depth;
		HashSet<String> seenURLs = new HashSet<String>();
		seenURLs.add(startURL);
		while (!toVisit.isEmpty()) {
			URLDepthPair currPair = toVisit.removeFirst();
			depth = currPair.getDepth();
			try {
				Socket sock = new Socket();
				sock.connect(new InetSocketAddress(currPair.getHost(), 80), 3000);
				sock.setSoTimeout(3000);
				System.out.println("Connected to " + currPair.getURLString());
				PrintWriter out =
				        new PrintWriter(sock.getOutputStream(), true);
			    BufferedReader in =
			        new BufferedReader(
			            new InputStreamReader(sock.getInputStream()));
			    out.println("GET " + currPair.getPath() + " HTTP/1.1");
			    out.println("Host: " + currPair.getHost());
			    out.println("Connection: close");
			    out.println();
			    out.flush();
			    String line;
			    int lineLength;
			    int shiftIdx;
			    while ((line = in.readLine()) != null) {
				    boolean foundFullLink = false;
			    	int idx = line.indexOf(HREF_TAG);
			    	if (idx > 0) {
			    		StringBuilder sb = new StringBuilder();
			    		shiftIdx = idx + 9;
			    		char c = line.charAt(shiftIdx);
			    		lineLength = line.length();
			    		while (c != '"' && shiftIdx < lineLength - 1) {
			    			sb.append(c);
			    			shiftIdx++;
			    			c = line.charAt(shiftIdx);
			    			if (c == '"') {
			    				foundFullLink = true;
			    			}
			    		}
				    		// Create a new pair for this link
			    			String newUrl = sb.toString();
			    			if (foundFullLink && depth < maxDepth && 
			    					!seenURLs.contains(newUrl)) {
			    				URLDepthPair newPair = 
					    				new URLDepthPair(newUrl, depth + 1);
					    		toVisit.add(newPair);
					    		seenURLs.add(newUrl);
			    			}
				    	}
			    	}	
			    sock.close();
			    allSitesSeen.add(currPair);
			}
			catch (IOException e) {
			}
		}
		for (URLDepthPair pair : allSitesSeen) {
			System.out.println(pair.toString());
		}
	}
	public static void main(String[] args) throws MalformedURLException {
		if (args.length != 2) {
			System.out.println("usage: java Crawler <URL> <maximum_depth>");
			return;
		}
		String startURL = args[0];
		int maxDepth = Integer.parseInt(args[1]);
		crawl(startURL, maxDepth);	
	}
}
