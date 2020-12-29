// package rabbitmq;
//
// import com.rabbitmq.client.Channel;
// import com.rabbitmq.client.Connection;
// import com.rabbitmq.client.ConnectionFactory;
//
// import java.util.concurrent.TimeoutException;
//
// public class ProduceLogs {
//    private static final String EXCHANGE_NAME = "logs";
//
//    public static void main(String[] argv)
//            throws java.io.IOException {
//        Connection connection = null;
//        Channel channel = null;
//
//        try {
//            ConnectionFactory factory = new ConnectionFactory();
//            factory.setHost("localhost");
//            connection = factory.newConnection();
//            channel = connection.createChannel();
//            channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
//
//            String message = "Sample log";
//
//            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
//            System.out.println(" [x] Sent '" + message + "'");
//
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                channel.close();
//                connection.close();
//            } catch (TimeoutException e) {
//                e.printStackTrace();
//            }
//        }
//    }
// }
