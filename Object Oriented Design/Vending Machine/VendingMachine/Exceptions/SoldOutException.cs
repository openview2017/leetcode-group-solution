using System;

namespace VendingMachineService.Exceptions
{
    public class SoldOutException : Exception
    {
        public SoldOutException()
        {
        }

        public SoldOutException(string message) : base(message)
        {
        }

        public SoldOutException(string message, Exception inner) : base(message, inner)
        {
        }
    }
}
