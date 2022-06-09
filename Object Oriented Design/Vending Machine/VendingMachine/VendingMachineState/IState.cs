namespace VendingMachineService.VendingMachineState
{
    /// <summary>
    /// Vending machine state
    /// </summary>
    public interface IState
    {
        void Handle();
        string ToString();
    }
}
