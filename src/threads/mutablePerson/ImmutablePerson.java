package threads.mutablePerson;

public final class ImmutablePerson {
    private final String name;
    private final String address;
    public ImmutablePerson(String name, String address) {
        this.name = name;
        this.address = address;
    }
    public  ImmutablePerson(MutablePerson person) {
//        synchronized(person) {     // 放在临界区,否则可能已经被其他修改修改了
            this.name = person.getName();
            this.address = person.getAddress();
//        }
    }
    public MutablePerson getMutablePerson() {
        return new MutablePerson(this);
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "[ ImmutablePerson: " + name + ", " + address + " ]";
    }
}
