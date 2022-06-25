using System;
using System.Linq;
using VendingMachineService.Exceptions;
using VendingMachineService.Objects;

namespace VendingMachineService.Services
{
    public class CashPaymentService : IPaymentService
    {
        private readonly VendingMachine _vendingMachine;
        public CashPaymentService(VendingMachine vendingMachine)
        {
            _vendingMachine = vendingMachine;
        }

        public void AddBalance(decimal totalPrice, decimal currentBalance)
        {
            Console.WriteLine($"You need to insert at least {totalPrice - currentBalance} amount of money.");
            Console.Write("Please insert money (Amount): ");
            var amount = decimal.Parse(Console.ReadLine() ?? string.Empty);
            _vendingMachine.AddBalance(amount);
            Console.WriteLine($"The current balance is {_vendingMachine.CurBalance}");
        }

        /// <summary>
        /// Given a certain value, calculate the coins needed and the amount of each coin.
        /// </summary>
        /// <param name="amount">The amount of money that will be converted to changes.</param>
        /// <returns></returns>
        /// <exception cref="NotSufficientChangeException"></exception>
        public Inventory<Money> GetChanges(decimal amount)
        {
            var changes = new Inventory<Money>();
            // Pick only coins instead of bills with the sorted denomination, from high to low. Fill the amount.
            var changesInStock = _vendingMachine.CurChanges.GetAllItems()
                .Where(x => x.Type == MoneyType.COIN).OrderByDescending(x => x.Value);
            foreach (var change in changesInStock)
            {
                if (amount <= change.Value) continue;
                var coinsNeeded = (int) (amount / change.Value);
                var coinsInStock = _vendingMachine.CurChanges.GetQuantity(change);
                var coinsUsed = Math.Min(coinsNeeded, coinsInStock);
                amount -= coinsUsed * change.Value;
                changes.Add(change, coinsUsed);
            }
            if (amount != 0)
            {
                throw new NotSufficientChangeException();
            }

            return changes;
        }

        public Inventory<Money> Refund(decimal amount)
        {
            return GetChanges(amount);
        }
    }
}
