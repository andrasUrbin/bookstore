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

        const addToCartButton = document.createElement('button');
        addToCartButton.setAttribute('id', Books[i].id);
        addToCartButton.addEventListener('click', onAddToCartClicked);
        addToCartButton.innerHTML = 'Add item to cart';
        addToCartForm.appendChild(addToCartButton);
        addToCartFormDiv.appendChild(addToCartForm);

        itemContainerDiv.appendChild(itemNameDiv);
        itemContainerDiv.appendChild(itemPriceDiv);
        itemContainerDiv.appendChild(addToCartFormDiv);

        booksContentDiv.appendChild(itemContainerDiv);
    }
}

function onAddBookResponse() {
    alert("Book added!");
    if (this.status === OK) {
        showContents(['books-content', 'topnav-admin']);
    } else {
        onOtherResponse(booksContentDivEl, this);
    }
}

function onAddBookClicked(){
    const inputFormEl = document.forms['addbook-form'];

    const titleEl = inputFormEl.querySelector('input[name="title"]');
    const authorEl = inputFormEl.querySelector('input[name="author"]');
    const descEl = inputFormEl.querySelector('input[name="desc"]');
    const priceEl = inputFormEl.querySelector('input[name="price"]');
    const categoryEl = inputFormEl.querySelector('input[name="category_id"]');

    const title = titleEl.value;
    const author = authorEl.value;
    const desc = descEl.value;
    const price = priceEl.value;
    const category = categoryEl.value;

    const params = new URLSearchParams();
    params.append('title', title);
    params.append('author', author);
    params.append('desc', desc);
    params.append('price', price);
    params.append('category_id', category);


    const xhr = new XMLHttpRequest();
    xhr.addEventListener('load', onAddBookResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('POST', 'book?' + params.toString());
    xhr.send();
}

function onAddBookAdmin(){
    showContents(['addbook-content', 'topnav-admin']);
}
