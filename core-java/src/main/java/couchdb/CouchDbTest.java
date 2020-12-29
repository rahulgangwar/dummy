// package couchdb;
//
// import java.net.MalformedURLException;
// import java.util.UUID;
//
// import org.ektorp.CouchDbConnector;
// import org.ektorp.CouchDbInstance;
// import org.ektorp.http.HttpClient;
// import org.ektorp.http.StdHttpClient;
// import org.ektorp.impl.StdCouchDbConnector;
// import org.ektorp.impl.StdCouchDbInstance;
// import org.ektorp.support.DesignDocument;
//
// public class CouchDbTest {
//    private static CouchDbInstance dbInstance;
//    private static CouchDbConnector db;
//
//    public static void main(String[] args) {
//        {
//            try {
//                HttpClient httpClient = new StdHttpClient.Builder()
//                        .url("http://localhost:5984")
//                        .build();
//                dbInstance = new StdCouchDbInstance(httpClient);
//
//                createDb("testdb1");
//                createDocument(UUID.randomUUID().toString());
//            } catch (MalformedURLException e) {
//                System.out.println("Exception : " + e.getMessage());
//                e.printStackTrace();
//            }
//        }
//    }
//
//    private static void createDb(String dbName) {
//        System.out.println("CouchDbTest.createDb");
//        db = new StdCouchDbConnector(dbName, dbInstance);
//        db.createDatabaseIfNotExists();
//    }
//
//    private static void createDocument(String id) {
//        System.out.println("CouchDbTest.createDocument");
//        System.out.println("List of all document ids :");
//        db.getAllDocIds().forEach(System.out::println);
//        System.out.println("Creating document with id : " + id);
//        DesignDocument dd = new DesignDocument(id);
//        db.create(dd);
//    }
// }
