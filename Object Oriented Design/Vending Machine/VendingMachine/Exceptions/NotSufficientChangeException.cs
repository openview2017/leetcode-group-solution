using System;

namespace VendingMachineService.Exceptions
{
    public class NotSufficientChangeException : Exception
    {
        public NotSufficientChangeException()
        {
        }

        public NotSufficientChangeException(string message) : base(message)
        {
        }

        public NotSufficientChangeException(string message, Exception inner) : base(message, inner)
        {
        }
    }
}
