const deleteButton = document.getElementById('delete-btn');

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('book-id').value;
        fetch(`/bms/books/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                alert('삭제되었습니다.');
                location.replace('/books');
            });
    });
}

const modifyButton = document.getElementById('modify-btn');

if (modifyButton) {
    modifyButton.addEventListener('click', event => {
        let params = new URLSearchParams(location.search);
        let id = params.get('id');

        fetch(`/bms/books/${id}`, {
            method: 'PUT',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                author: document.getElementById('author').value,
                publisher: document.getElementById('publisher').value,
                publicationDate: document.getElementById('publicationDate').value
            })
        })
            .then(() => {
                alert('수정 완료.');
                location.replace(`/books/${id}`);
            });
    });
}

const createButton = document.getElementById('create-btn');

if (createButton) {
    createButton.addEventListener('click', (event) => {
        fetch("/bms/books", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                author: document.getElementById('author').value,
                publisher: document.getElementById('publisher').value,
                publicationDate: document.getElementById('publicationDate').value
            }),
        }).then(() => {
            alert('등록 완료.');
            location.replace("/books");
        });
    });
}