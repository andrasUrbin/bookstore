let BooksEl;
let BooksUlEl;

function onBooksResponse() {
    if (this.status === OK) {
        showContents(['books-content', 'topnav-customer', 'cart-content']);
        onBooksLoad(JSON.parse(this.responseText));
    } else {
        onOtherResponse(booksContentDivEl, this);
    }
}

function onBooksLoad(Books) {
    BooksEl = document.getElementById('books');
    appendBooks(Books);
}

function appendBooks(Books) {
    const booksContentDiv = document.getElementById('books-content');
    removeAllChildren(booksContentDiv);

    for (let i = 0; i < Books.length; i ++) {
        const itemContainerDiv = document.createElement('div');
        itemContainerDiv.setAttribute('class', 'item-container');

        const itemNameDiv = document.createElement('div');
        itemNameDiv.setAttribute('class', 'item-name');
        const strongItemName = document.createElement('strong');
        strongItemName.innerHTML = Books[i].author + ': ' + Books[i].title;
        const strongItemP = document.createElement('p');
        strongItemP.appendChild(strongItemName);
        const itemP = document.createElement('p');
        itemP.innerHTML = 'Description: ' + Books[i].description;
        itemNameDiv.appendChild(strongItemP);
        itemNameDiv.appendChild(itemP);

        const itemPriceDiv = document.createElement('div');
        itemPriceDiv.setAttribute('class', 'item-price-container');
        const strongItemPrice = document.createElement('strong');
        strongItemPrice.innerHTML = Books[i].price + '$';
        const strongItemPriceP = document.createElement('p');
        strongItemPriceP.appendChild(strongItemPrice);
        itemPriceDiv.appendChild(strongItemPriceP);

        const addToCartFormDiv = document.createElement('div');
        addToCartFormDiv.setAttribute('class', 'add-to-cart');
        const addToCartForm = document.createElement('form');
        addToCartForm.setAttribute('class', 'buy-item-form');
        const selectEl = document.createElement('select');
        for (let k = 1; k < 11; k++) {
            const optionEl = document.createElement('option');
            optionEl.innerHTML = k;
            selectEl.appendChild(optionEl);
        }
        const addToCartButton = document.createElement('button');
        addToCartButton.setAttribute('id', 'itemId' + Books[i].id);
        addToCartButton.setAttribute('onclick', onAddToCartClicked);
        addToCartButton.innerHTML = 'Add item to cart';
        addToCartForm.appendChild(selectEl);
        addToCartForm.appendChild(addToCartButton);
        addToCartFormDiv.appendChild(addToCartForm);

        itemContainerDiv.appendChild(itemNameDiv);
        itemContainerDiv.appendChild(itemPriceDiv);
        itemContainerDiv.appendChild(addToCartFormDiv);

        booksContentDiv.appendChild(itemContainerDiv);
    }
}
