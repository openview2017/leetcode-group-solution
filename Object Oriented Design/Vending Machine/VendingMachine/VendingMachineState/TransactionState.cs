using System;
using VendingMachineService.Objects;
using VendingMachineService.Services;

namespace VendingMachineService.VendingMachineState
{
    public class TransactionState : State
    {
        public IPaymentService PaymentService { get; set; }

        public TransactionState(VendingMachine vendingMachine) : base(vendingMachine)
        {
            VendingMachine = vendingMachine;
        }

        public override void Handle()
        {
            var curPrice = VendingMachine.GetSalePrice();
            var curBalance = VendingMachine.CurBalance;
            var changes = PaymentService.GetChanges(curBalance - curPrice);
            foreach (var coin in changes.GetAllItems())
            {
                Console.WriteLine("The changes returned are.");
                Console.WriteLine($"Coin value: {coin.Value}, Coin Amount: {changes.GetQuantity(coin)}");
            }
            // Take items from vending machine item storage.
            VendingMachine.CurItems.Reduce(VendingMachine.CurSelectedItems);
            // Take items from vending machine changes storage.
            VendingMachine.CurChanges.Reduce(changes);
            VendingMachine.Reset();
        }
    }
}
