namespace VendingMachineService
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var vendingMachineService = new Services.VendingMachineService();
            vendingMachineService.Run();
        }
    }
}
