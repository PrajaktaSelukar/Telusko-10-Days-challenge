public class Apple implements interfaceData
{
    private void repair() {
        System.out.println("Repairing");
    }
    private void repair(int cost) {
        System.out.println("Repairing : " + cost);
    }

    @Override
    public void showInterface() {
        System.out.println("In the interface");
    }
}