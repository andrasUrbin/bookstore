function removeBook() {
    const cartTotalEl = document.getElementById('cart-total');
    const rowToRemove = document.getElementById('book'+this.getAttribute('book-id'));
    const rowToRemoveId = rowToRemove.rowIndex;
    cartTotalEl.innerHTML = cartTotalEl.innerHTML - rowToRemove.cells[3].innerHTML;
    cartTableEl.deleteRow(rowToRemoveId);
}

function addBookToCart(book) {
    const cartTotalEl = document.getElementById('cart-total');
    const idTrEl = document.createElement('tr');
    idTrEl.setAttribute('id', 'book'+book.id);
    nameTdEl = document.createElement('td');
    nameTdEl.innerHTML = book.title;
    const pcsTdEl = document.createElement('td');
    pcsTdEl.innerHTML = document.getElementById('select'+book.id).value;
    const priceTdEl = document.createElement('td');
    priceTdEl.innerHTML = book.price;
    const totalTdEl = document.createElement('td');
    totalTdEl.innerHTML = pcsTdEl.innerHTML * priceTdEl.innerHTML;
    cartTotalEl.innerHTML = + cartTotalEl.innerHTML + + totalTdEl.innerHTML;
    const removeButtonTdEl = document.createElement('td');
    const removeButton = document.createElement('button');
    removeButton.setAttribute('book-id', book.id);
    removeButton.addEventListener('click', removeBook);
    removeButton.innerHTML = 'X';
    removeButton.setAttribute('class', 'minimal-button');
    removeButtonTdEl.appendChild(removeButton);

    idTrEl.appendChild(nameTdEl);
    idTrEl.appendChild(pcsTdEl);
    idTrEl.appendChild(priceTdEl);
    idTrEl.appendChild(totalTdEl);
    idTrEl.appendChild(removeButtonTdEl);

    cartTableEl.appendChild(idTrEl);
}

function onAddToCartResponse() {
    if (this.status === OK) {
        book = JSON.parse(this.responseText);
        //showContents(['books-content', 'topnav-customer', 'cart-content']);
        addBookToCart(book);
    } else {
        onOtherResponse(this);
    }
}

function onAddToCartClicked() {
    const thisBookId = this.id.split('Id')[1];
    console.log(thisBookId);
    const params = new URLSearchParams;
    params.append('id', thisBookId);

    const xhr = new XMLHttpRequest;
    xhr.addEventListener('load', onAddToCartResponse);
    xhr.addEventListener('error', onNetworkError);
    xhr.open('GET', '/protected/book?' + params);
    xhr.send();
}
