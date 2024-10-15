public class State {
    public String stateName;
    public int populationCount;

    public State(String name, int population) {
        this.stateName = name;
        this.populationCount = population;
    }

    public void Show() {
        System.out.println("State: " + stateName + ", Population: " + populationCount);
    }
}

class Republic extends State {
    private final String presidentName;

    public Republic(String name, int population, String presidentName) {
        super(name, population);
        this.presidentName = presidentName;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Type: Republic, President: " + presidentName);
    }
}

class Monarchy extends State {
    private final String kingName;

    public Monarchy(String name, int population, String kingName) {
        super(name, population);
        this.kingName = kingName;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Type: Monarchy, King: " + kingName);
    }
}

class Kingdom extends Monarchy {
    private final int numberOfProvinces;

    public Kingdom(String name, int population, String kingName, int numberOfProvinces) {
        super(name, population, kingName);
        this.numberOfProvinces = numberOfProvinces;
    }

    @Override
    public void Show() {
        super.Show();
        System.out.println("Type: Kingdom, Provinces: " + numberOfProvinces);
    }
}
