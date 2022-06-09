using System;
using VendingMachineService.Objects;

namespace VendingMachineService.VendingMachineState
{
    public class PaymentState : State
    {
        public PaymentState(VendingMachine vendingMachine) : base(vendingMachine)
        {
            this.vendingMachine = vendingMachine;
        }

        public override void Handle()
        {
            var totalPrice = vendingMachine.GetSalePrice();
            Console.WriteLine($"Current total price is: {totalPrice}");
            var paymentService = new CashPaymentService(vendingMachine);
            while (vendingMachine.CurBalance < totalPrice)
            {
                paymentService.AddBalance(totalPrice, vendingMachine.CurBalance);
            }
        }
    }
}
