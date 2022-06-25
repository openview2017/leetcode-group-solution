using VendingMachineService.Objects;

namespace VendingMachineService.VendingMachineState
{
    public abstract class State : IState
    {
        protected VendingMachine VendingMachine;

        protected State(VendingMachine vendingMachine)
        {
            VendingMachine = vendingMachine;
        }

        public abstract void Handle();

        public override string ToString()
        {
            return GetType().Name;
        }
    }
}
