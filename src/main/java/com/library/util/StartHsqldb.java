package com.library.util;

import org.hsqldb.util.DatabaseManagerSwing;

//java -cp ../lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:mydb --dbname.0 xdb
//java -cp ../lib/hsqldb.jar org.hsqldb.server.WebServer --database.0 file:mydb --dbname.0 xdb

// Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/xdb", "SA", "");
// Connection c = DriverManager.getConnection("jdbc:hsqldb:http://localhost/xdb", "SA", "");
public class StartHsqldb {
static String FILE_URI="file:hsqldb";

public StartHsqldb() {
	//serverhsqldb();
}

public static void main(String[] args) {
	//localhsqldb();
	serverhsqldb();
}

public static void localhsqldb() {
	String[] dbArgs = {"--user", "sa", "--password", "", "--url", "jdbc:hsqldb:"+FILE_URI};
	DatabaseManagerSwing.main(dbArgs);
}

public static void serverhsqldb() {
	String[] dbArgs = {"--database.0", FILE_URI, "--dbname.0", "hsqldb", "--port", "5454"};
	org.hsqldb.server.Server.main(dbArgs);
}

public static void serverhsqldb1() {
	String[] dbArgs = {"--database.0", FILE_URI, "--dbname.0", "hsqldb", "--port", "5454"};
	org.hsqldb.server.WebServer.main(dbArgs);
}

}