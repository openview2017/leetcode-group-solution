using System;
using VendingMachineService.Objects;

namespace VendingMachineService.VendingMachineState
{
    public class TransactionState : State
    {
        public TransactionState(VendingMachine vendingMachine) : base(vendingMachine)
        {
            this.vendingMachine = vendingMachine;
        }

        public override void Handle()
        {
            var paymentService = new CashPaymentService(vendingMachine);
            var curPrice = vendingMachine.GetSalePrice();
            var curBalance = vendingMachine.CurBalance;
            var changes = paymentService.GetChanges(curBalance - curPrice);
            foreach (var coin in changes.GetAllItems())
            {
                Console.WriteLine("The changes returned are.");
                Console.WriteLine($"Coin value: {coin.Value}, Coin Amount: {changes.GetQuantity(coin)}");
            }
            vendingMachine.CurItems.Reduce(vendingMachine.CurSelectedItems);
            vendingMachine.Reset();
        }
    }
}
