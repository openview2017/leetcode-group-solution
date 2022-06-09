using VendingMachineService.Objects;

namespace VendingMachineService.Services
{
    public interface ISelectionService
    {
        /// <summary>
        /// Use vending machine UI to select items and their quantity.
        /// </summary>
        /// <returns>Items with their quantity.</returns>
        Inventory<Item> GetSelectedItems();

        /// <summary>
        /// Show current list of items in stock to choose from.
        /// </summary>
        void ShowMenu();
    }
}
