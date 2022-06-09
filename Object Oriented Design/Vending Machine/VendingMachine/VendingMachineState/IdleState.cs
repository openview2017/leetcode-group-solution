using VendingMachineService.Objects;

namespace VendingMachineService.VendingMachineState
{
    /// <summary>
    /// The state when vending machine is idle. User has to select an item to purchase.
    /// </summary>
    public class IdleState : State
    {
        public IdleState(VendingMachine vendingMachine) : base(vendingMachine)
        {
            this.vendingMachine = vendingMachine;
        }
        public override void Handle()
        {
            var selectionService = new CmdSelectionService(vendingMachine);
            var items = selectionService.GetSelectedItems();
            vendingMachine.SelectItem(items);
            return;
        }
    }
}
