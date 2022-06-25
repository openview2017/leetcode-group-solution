using System;
using VendingMachineService.Objects;
using VendingMachineService.Services;

namespace VendingMachineService.VendingMachineState
{
    public class PaymentState : State
    {
        public IPaymentService PaymentService { get; set; }

        public PaymentState(VendingMachine vendingMachine) : base(vendingMachine)
        {
            VendingMachine = vendingMachine;
        }

        public override void Handle()
        {
            var totalPrice = VendingMachine.GetSalePrice();
            Console.WriteLine($"Current total price is: {totalPrice}");
            while (VendingMachine.CurBalance < totalPrice)
            {
                PaymentService.AddBalance(totalPrice, VendingMachine.CurBalance);
            }
        }
    }
}
