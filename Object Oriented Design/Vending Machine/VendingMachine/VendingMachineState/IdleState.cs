using VendingMachineService.Objects;
using VendingMachineService.Services;

namespace VendingMachineService.VendingMachineState
{
    /// <summary>
    /// The state when vending machine is idle. User has to select an item to purchase.
    /// </summary>
    public class IdleState : State
    {
        public ISelectionService SelectionService { get; set; }

        public IdleState(VendingMachine vendingMachine) : base(vendingMachine)
        {
            VendingMachine = vendingMachine;
        }

        public override void Handle()
        {
            var items = SelectionService.GetSelectedItems();
            VendingMachine.SelectItem(items);
        }
    }
}
