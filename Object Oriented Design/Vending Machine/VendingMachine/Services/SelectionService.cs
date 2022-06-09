using System;
using System.Linq;
using System.Collections.Generic;
using VendingMachineService.Objects;
using VendingMachineService.Exceptions;
using VendingMachineService.Services;

namespace VendingMachineService
{
    /// <summary>
    /// Vending machine item selection service using command line.
    /// TO-DO: Add more selection services, for example, button selections services, numpad selection services.
    /// </summary>
    public class CmdSelectionService : ISelectionService
    {
        private readonly VendingMachine vendingMachine;

        public CmdSelectionService(VendingMachine vendingMachine)
        {
            this.vendingMachine = vendingMachine;
        }

        /// <summary>
        /// Use command line to input the item to select and its quantity.
        /// </summary>
        /// <returns></returns>
        /// <exception cref="OutOfInventoryException">If item quantity in stock is less than the selected quantity, the system will raise this exception.</exception>
        public Inventory<Item> GetSelectedItems()
        {
            var selectedItems = new Inventory<Item>();
            ShowMenu();
            Console.WriteLine("Do you want to select an item? (Y/N)");
            while (Console.ReadLine().ToLower().Contains("y"))
            {
                Console.Write("Please select an item: ");
                string itemName = Console.ReadLine();
                Console.Write("Please put in the amount: ");
                int.TryParse(Console.ReadLine(), out int amount);
                var curItem = vendingMachine.CurItems.GetAllItems().FirstOrDefault(x => x.Name == itemName);
                if (vendingMachine.CurItems.GetQuantity(curItem) - selectedItems.GetQuantity(curItem) < amount)
                {
                    throw new OutOfInventoryException($"{itemName} is out of inventory. Please put in another amount.");
                }
                else
                {
                    selectedItems.Add(curItem, amount);
                }
                Console.WriteLine("Do you want to select another item? (Y/N)");
            }
            return selectedItems;
        }

        public void ShowMenu()
        {
            var itemNames = vendingMachine?.CurItems?.Item?.Keys?.ToList() ?? new List<Item>();
            Console.WriteLine("Current Items in inventory:");
            foreach (var itemName in itemNames)
            {
                Console.WriteLine(itemName.Name);
            }
        }
    }
}
