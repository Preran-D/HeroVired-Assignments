let customers = [
    {customerID: 1, customerName: 'John Doe', totalBillingAmount: 2500},
    {customerID: 2, customerName: 'Jane Doe', totalBillingAmount: 3500},
    {customerID: 3, customerName: 'Jim Doe', totalBillingAmount: 4000},
    {customerID: 4, customerName: 'Jake Doe', totalBillingAmount: 4500},
    {customerID: 5, customerName: 'Jill Doe', totalBillingAmount: 5000},
    {customerID: 6, customerName: 'Jerry Doe', totalBillingAmount: 5500},
    {customerID: 7, customerName: 'Jenny Doe', totalBillingAmount: 6000},
    {customerID: 8, customerName: 'Jeff Doe', totalBillingAmount: 6500},
    {customerID: 9, customerName: 'Jesse Doe', totalBillingAmount: 7000},
    {customerID: 10, customerName: 'Jamie Doe', totalBillingAmount: 7500},
];


let selectCustomers = customers.filter(customer => customer.totalBillingAmount > 3000);

let customerDetails = selectedCustomers.map(customer => {
    return {name: customer.customerName, purchase: customer.totalBillingAmount};
});


console.log(customerDetails);
