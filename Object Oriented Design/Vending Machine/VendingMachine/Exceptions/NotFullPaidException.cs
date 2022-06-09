using System;

namespace VendingMachineService.Exceptions
{
    public class NotFullPaidException : Exception
    {
        public NotFullPaidException()
        {
        }

        public NotFullPaidException(string message) : base(message)
        {
        }

        public NotFullPaidException(string message, Exception inner): base(message, inner)
        {
        }
    }
}
