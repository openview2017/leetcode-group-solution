using VendingMachineService.VendingMachineState;

namespace VendingMachineService.Objects
{
    public class VendingMachine
    {
        private IState CurState;

        /// <summary>
        /// Current item customer has selected. Null if nothing selected.
        /// </summary>
        public Inventory<Item> CurSelectedItems { get; }

        /// <summary>
        /// Current amount of money customer has inserted or provided.
        /// </summary>
        public decimal CurBalance { get; private set; }

        /// <summary>
        /// Current products the vending machine has.
        /// </summary>
        public Inventory<Item> CurItems { get; }

        /// <summary>
        /// Current coins and amount in vending machine.
        /// </summary>
        public Inventory<Money> CurChanges { get; }


        public VendingMachine()
        {
            CurSelectedItems = new Inventory<Item>();
            CurState = null;
            CurItems = new Inventory<Item>();
            CurChanges = new Inventory<Money>();
            CurBalance = 0;
        }

        /// <summary>
        /// Vending machine handle current state.
        /// </summary>
        public void Handle()
        {
            CurState.Handle();
        }

        /// <summary>
        /// Add one item to vending machine.
        /// </summary>
        /// <param name="item"></param>
        public void AddItemToStorage(Inventory<Item> item)
        {
            CurItems.Add(item);
        }

        /// <summary>
        /// Remove one item from vending machine.
        /// Amount should always be smaller than the current inventory amount.
        /// </summary>
        /// <param name="item"></param>
        public void RemoveItemFromStorage(Inventory<Item> item)
        {
            CurItems.Reduce(item);
        }

        /// <summary>
        /// Select an inventory of items from current inventory.
        /// </summary>
        /// <param name="item"></param>
        public void SelectItem(Inventory<Item> item)
        {
            CurSelectedItems.Add(item);
        }

        private void ResetSelectedItems()
        {
            CurSelectedItems.Clear();
        }

        /// <summary>
        /// Add coins as changes to vending machine.
        /// </summary>
        /// <param name="coins"></param>
        public void AddChanges(Inventory<Money> coins)
        {
            CurChanges.Add(coins);
        }

        /// <summary>
        /// Reduce certain amount of coin changes from vending machine.
        /// </summary>
        /// <param name="coins"></param>
        public void ReduceChanges(Inventory<Money> coins)
        {
            CurChanges.Reduce(coins);
        }

        /// <summary>
        /// Customer insert money to the vending machine to add current balance for purchasing.
        /// </summary>
        /// <param name="amount"></param>
        public void AddBalance(decimal amount)
        {
            CurBalance += amount;
        }

        /// <summary>
        /// Reset current inserted money to 0.
        /// </summary>
        private void ResetBalance()
        {
            CurBalance = 0;
        }

        /// <summary>
        /// Get current selected items total value.
        /// </summary>
        /// <returns>Current selected items price.</returns>
        public decimal GetSalePrice()
        {
            decimal price = 0;
            foreach(var kvp in CurSelectedItems.Item)
            {
                price += kvp.Key.Price * kvp.Value;
            }
            return price;
        }

        /// <summary>
        /// Set current state to the new state.
        /// </summary>
        /// <param name="state"></param>
        public void SetState(IState state)
        {
            CurState = state;
        }

        public void Reset()
        {
            ResetBalance();
            ResetSelectedItems();
        }

        public string PrintState()
        {
            var res = "Current state is : " + CurState.ToString();

            return res;
        }
    }
}
