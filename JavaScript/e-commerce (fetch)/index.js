document.addEventListener('DOMContentLoaded', function () {
    const searchInput = document.getElementById('searchInput');
    const productContainer = document.getElementById('product-container');

    function createProductCard(product) {
        const productCard = document.createElement('div');
        productCard.classList.add('product-card');

        const thumbnail = document.createElement('img');
        thumbnail.src = product.thumbnail;
        thumbnail.alt = product.title;
        thumbnail.classList.add('product-thumbnail');

        const title = document.createElement('div');
        title.textContent = product.title;
        title.classList.add('product-title');

        const description = document.createElement('div');
        description.textContent = product.description;
        description.classList.add('product-description');

        const price = document.createElement('div');
        price.textContent = `$${product.price.toFixed(2)}`;
        price.classList.add('product-price');

        const rating = document.createElement('div');
        rating.textContent = `Rating: ${product.rating}`;
        rating.classList.add('product-rating');

        productCard.appendChild(thumbnail);
        productCard.appendChild(title);
        productCard.appendChild(description);
        productCard.appendChild(price);
        productCard.appendChild(rating);

        return productCard;
    }

    function updateProductList(searchQuery) {
        fetch(`https://dummyjson.com/products/search?q=${searchQuery}`)
            .then(res => res.json())
            .then(data => {
                productContainer.innerHTML = '';
                data.products.forEach(product => {
                    const productCard = createProductCard(product);
                    productContainer.appendChild(productCard);
                });
            })
            .catch(error => console.error('Error fetching data:', error));
    }

    searchInput.addEventListener('input', function (event) {
        const searchQuery = event.target.value.trim();
        updateProductList(searchQuery);
    });

    fetch('https://dummyjson.com/products')
        .then(res => res.json())
        .then(data => {
            data.products.forEach(product => {
                const productCard = createProductCard(product);
                productContainer.appendChild(productCard);
            });
        })
        .catch(error => console.error('Error fetching data:', error));
});
