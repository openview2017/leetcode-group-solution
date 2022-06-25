using System;
namespace VendingMachineService.Objects
{
    public class Money : IComparable<Money>
    {
        public decimal Value { get; }

        /// <summary>
        /// Money can be bill or coin.
        /// </summary>
        public MoneyType Type { get; }
        
        /// <summary>
        /// The currency type of the money.
        /// </summary>
        public CurrencyType CurrencyType { get; } 
        public Money(decimal moneyValue, MoneyType moneyType, CurrencyType currencyType = CurrencyType.USD)
        {
            Value = moneyValue;
            Type = moneyType;
            CurrencyType = currencyType;

        }

        public override bool Equals(object obj)
        {
            if (obj.GetType() != typeof(Money))
            {
                return false;
            }
            var other = (Money)obj;
            return Value == other.Value && Type == other.Type && CurrencyType == other.CurrencyType;
        }

        public override int GetHashCode()
        {
            return Value.GetHashCode() ^ Type.GetHashCode() ^ CurrencyType.GetHashCode();
        }

        public int CompareTo(Money other)
        {
            return (Value.CompareTo(other.Value));
        }
    }
}