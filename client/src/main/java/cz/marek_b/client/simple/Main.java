package cz.marek_b.client.simple;

public class Main {

    public static void main(String[] args) {
        try {
            SimpleConnection simpleConnection = new SimpleConnection();
            System.out.println("------------- GET -------------");
            simpleConnection.sendGet();
            System.out.println("-------------------------------");
            
            System.out.println("------------- POST -------------");
            simpleConnection.sendPost();
            System.out.println("--------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
