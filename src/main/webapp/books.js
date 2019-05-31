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
    const bookLiEl = document.createElement('li')
    const aEl = document.createElement('a');
    bookLiEl.appendChild(aEl);
    aEl.textContent = book.title;
    aEl.href = 'javascript:void(0);';
    aEl.dataset.BookId = book.id;
    //aEl.addEventListener('click', onBookClicked);


    BooksUlEl.appendChild(bookLiEl);
}
