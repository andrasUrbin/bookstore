let BooksEl;
let BooksUlEl;

function onBooksResponse() {
    if (this.status === OK) {
        showContents(['books-content', 'topnav-customer']);
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
    //shopContentDiv.insertBefore(newElement, shopContendDiv.firstchild); !!!

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
function appendBook(book) {
    const bookLiEl = document.createElement('li');
    const aEl = document.createElement('a');
    const olElement = document.createElement('ol');

    const liElementAuthor = document.createElement('li');
    const liElementCategory = document.createElement('li');
    const liElementDescription = document.createElement('li');
    const liElementPrice = document.createElement('li');
    aEl.textContent = book.title;


    liElementAuthor.textContent = "Author: " + book.author;
    liElementCategory.textContent = "Category of the book: " + book.category.name;
    liElementDescription.textContent = "Description: " + book.description;
    liElementPrice.textContent = "Price of the book: " + book.price;
    bookLiEl.appendChild(olElement);

    olElement.appendChild(liElementAuthor);
    olElement.appendChild(liElementCategory);
    olElement.appendChild(liElementDescription);
    olElement.appendChild(liElementPrice);
    bookLiEl.appendChild(aEl);
    aEl.href = 'javascript:void(0);';
    aEl.dataset.BookId = book.id;
    //aEl.addEventListener('click', onBookClicked);


    BooksUlEl.appendChild(bookLiEl);
}
