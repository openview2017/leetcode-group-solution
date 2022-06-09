using VendingMachineService.Objects;

namespace VendingMachineService.VendingMachineState
{
    public abstract class State : IState
    {
        protected VendingMachine vendingMachine;

        public State(VendingMachine vendingMachine)
        {
            this.vendingMachine = vendingMachine;
        }

        public abstract void Handle();

        public override string ToString()
        {
            return this.GetType().Name;
        }
    }
}
