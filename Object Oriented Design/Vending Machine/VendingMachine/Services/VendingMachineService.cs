﻿using VendingMachineService.Objects;
using VendingMachineService.VendingMachineState;

namespace VendingMachineService
{
    public class VendingMachineService
    {
        public VendingMachine VendingMachine { get; set; }
        public void Init()
        {
            VendingMachine = new VendingMachine();

            //TO-DO: Add config and read the initial settings from config instead of hard code.
            var coinChanges = new Inventory<Money>();
            coinChanges.Add(new Money(0.01m, MoneyType.COIN), 500);
            coinChanges.Add(new Money(0.05m, MoneyType.COIN), 500);
            coinChanges.Add(new Money(0.10m, MoneyType.COIN), 300);
            coinChanges.Add(new Money(0.25m, MoneyType.COIN), 200);
            coinChanges.Add(new Money(0.50m, MoneyType.COIN), 100);
            coinChanges.Add(new Money(1, MoneyType.COIN), 50);
            VendingMachine.AddChanges(coinChanges);

            var items = new Inventory<Item>();
            items.Add(new Item("Coke", "001", 2.5m, ItemType.SODA), 20);
            items.Add(new Item("Mocha", "002", 4.0m, ItemType.COFFEE), 10);
            VendingMachine.AddItemToStorage(items);
        }
        

        public void Run()
        {
            Init();
            VendingMachine.SetState(new IdleState(VendingMachine));
            VendingMachine.Handle();
            VendingMachine.SetState(new PaymentState(VendingMachine));
            VendingMachine.Handle();
            VendingMachine.SetState(new TransactionState(VendingMachine));
            VendingMachine.Handle();
        }
    }
}
