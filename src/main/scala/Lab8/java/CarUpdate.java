import com.basho.riak.client.api.commands.kv.UpdateValue;

public class CarUpdate extends UpdateValue.Update<Car>{
    private final Car update;
    public CarUpdate(Car update){
        this.update = update;
    }

    @Override
    public Car apply(Car t) {
        if(t == null) {
            t = new Car();
        }

        t.car = update.car;
        t.type = update.type;
        t.fuel = update.fuel;
        t.year = update.year;

        return t;
    }
}
