let BooksEl;
let BooksUlEl;

function onBooksResponse() {
    if (this.status === OK) {
        showContents(['books-content', 'topnav']);
        onBooksLoad(JSON.parse(this.responseText));
    } else {
        onOtherResponse(booksContentDivEl, this);
    }
}

function onBooksLoad(Books) {
    BooksEl = document.getElementById('books');
    BooksUlEl = BooksEl.querySelector('ul');
    console.log(Books);
    appendBooks(Books);
}

function appendBooks(Books) {
    removeAllChildren(BooksUlEl);

    for (let i = 0; i < Books.length; i++) {
        const book = Books[i];
        appendBook(book);
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
