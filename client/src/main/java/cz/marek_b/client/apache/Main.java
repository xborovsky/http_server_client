package cz.marek_b.client.apache;

public class Main {

    public static void main(String[] args) {
        try {
            SimpleApacheHttpClient client = new SimpleApacheHttpClient();
            System.out.println("------------ GET ------------");
            client.sendGet();
            System.out.println("-----------------------------");
            
            System.out.println("------------ POST ------------");
            client.sendPost();
            System.out.println("-----------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
