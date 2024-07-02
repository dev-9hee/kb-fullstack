package afternoon.nested.nested.ex1;

public class NetworkMain {
    public static void main(String[] args) {
        Network network = new Network();
        if (network.checkNetwork()) {
            network.sendMsg("내일도 비오려나??");
        }
    }
}
