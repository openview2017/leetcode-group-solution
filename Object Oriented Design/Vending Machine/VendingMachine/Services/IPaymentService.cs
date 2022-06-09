using VendingMachineService.Objects;

namespace VendingMachineService.Services
{
    public interface IPaymentService
    {
        void AddBalance(decimal totalPrice, decimal currentBalance);
        Inventory<Money> GetChanges(decimal amount);
        Inventory<Money> Refund(decimal amount);
    }
}
