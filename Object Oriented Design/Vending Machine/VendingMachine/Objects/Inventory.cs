using System.Collections.Generic;
using VendingMachineService.Exceptions;

namespace VendingMachineService.Objects
{
    public class Inventory<T>
    {
        public Dictionary<T, int> Item { get; }

        public Inventory() => Item = new Dictionary<T, int>();

        /// <summary>
        /// Get quantity of selected item. Return 0 if item is not in current inventory.
        /// </summary>
        /// <param name="item"></param>
        /// <returns></returns>
        public int GetQuantity(T item)
        {
            if (Item == null)
            {
                return 0;
            }
            var _ = Item.TryGetValue(item, out int amount);
            return amount;
        }

        /// <summary>
        /// Add item to current inventory.
        /// </summary>
        /// <param name="item">Item to be added.</param>
        /// <param name="quantity">Quantity of item to add. Default as 1.</param>
        public void Add(T item, int quantity = 1)
        {
            Item.TryGetValue(item, out int curQuantity);
            Item[item] = curQuantity + quantity;
        }

        /// <summary>
        /// Add another inventory to current inventory.
        /// </summary>
        /// <param name="inventoryToAdd">Another inventory of items.</param>
        public void Add(Inventory<T> inventoryToAdd)
        {
            foreach (var kvp in inventoryToAdd.Item)
            {
                Add(kvp.Key, kvp.Value);
            }
        }

        /// <summary>
        /// Reduce item from current inventory. Usually when retrieving items from inventory.
        /// </summary>
        /// <param name="item">Item to be reduced.</param>
        /// <param name="quantity">Quantity of item to reduce. Default as 1.</param>
        /// <exception cref="OutOfInventoryException"></exception>
        public void Reduce(T item, int quantity = 1)
        {
            Item.TryGetValue(item, out int curQuantity);
            if(curQuantity < quantity)
            {
                throw new OutOfInventoryException("Inventory cannot fulfill the quantity to reduce.");
            }
            Item[item] = curQuantity - quantity;
        }

        /// <summary>
        /// Reduce another inventory from current inventory.
        /// </summary>
        /// <param name="inventoryToReduce">Another inventory of items.</param>
        public void Reduce(Inventory<T> inventoryToReduce)
        {
            foreach (var kvp in inventoryToReduce.Item)
            {
                Reduce(kvp.Key, kvp.Value);
            }
        }

        /// <summary>
        /// Check if inventory has a certain item.
        /// </summary>
        /// <param name="item"></param>
        /// <returns>True if item exists. False otherwise.</returns>
        public bool HasItem(T item)
        {
            return Item.ContainsKey(item);
        }

        /// <summary>
        /// Get all items in current inventory as a list.
        /// </summary>
        /// <returns>List of items.</returns>
        public List<T> GetAllItems()
        {
            return new List<T>(Item.Keys);
        }

        /// <summary>
        /// Clear current inventory.
        /// </summary>
        public void Clear()
        {
            Item.Clear();
        }
    }
}
