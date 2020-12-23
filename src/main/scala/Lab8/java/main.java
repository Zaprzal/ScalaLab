import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.commands.kv.DeleteValue;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.api.commands.kv.StoreValue;
import com.basho.riak.client.api.commands.kv.UpdateValue;
import com.basho.riak.client.core.RiakCluster;
import com.basho.riak.client.core.RiakNode;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;
import com.basho.riak.client.core.query.RiakObject;


import java.net.UnknownHostException;

public class main {

    public static void main( String[] args ) {
        try {


//          utworzenie klienta
            RiakCluster cluster = setUpCluster();
            RiakClient client = new RiakClient(cluster);

//          ustawienie lokalizacji docelowej
            Namespace bucket = new Namespace("cars");
            Location car_lockation = new Location(bucket, "BMW");


            Car c1 = new Car("BMW" , "F30" , "Diesel" , 2010);


//          dodanie do bazy RIAK
            StoreValue storeBookOp = new StoreValue.Builder(c1)
                    .withLocation(car_lockation)
                    .build();
            client.execute(storeBookOp);

//          Pobranie pojazdu z bazy
            FetchValue fetchMobyDickOp = new FetchValue.Builder(car_lockation)
                    .build();
            Car pobrany_pojazd = client.execute(fetchMobyDickOp).getValue(Car.class);

            System.out.println("Pojazd pobrany z bazy: " + pobrany_pojazd.toString());

//          Aktualizacja pojazdu
            pobrany_pojazd.year = 2021;

            CarUpdate myupdatedcar = new CarUpdate(pobrany_pojazd);

            UpdateValue updateValue = new UpdateValue.Builder(car_lockation)
                    .withUpdate(myupdatedcar).build();
            UpdateValue.Response response = client.execute(updateValue);

            fetchMobyDickOp = new FetchValue.Builder(car_lockation)
                    .build();
            pobrany_pojazd = client.execute(fetchMobyDickOp).getValue(Car.class);

            System.out.println("Pojazd pobrany po update: " + pobrany_pojazd.toString());

//          Usuwanie pojazdu

            DeleteValue deleteOp = new DeleteValue.Builder(car_lockation)
                    .build();
            client.execute(deleteOp);

            fetchMobyDickOp = new FetchValue.Builder(car_lockation)
                    .build();
            pobrany_pojazd = client.execute(fetchMobyDickOp).getValue(Car.class);

            if(pobrany_pojazd == null){
                System.out.println("Pojazd usunięty z bazy");
            }


            cluster.shutdown();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }





    private static RiakCluster setUpCluster() throws UnknownHostException {

        RiakNode node = new RiakNode.Builder()
                .withRemoteAddress("127.0.0.1")
                .withRemotePort(8087)
                .build();


        RiakCluster cluster = new RiakCluster.Builder(node)
                .build();


        cluster.start();

        return cluster;
    }

}
