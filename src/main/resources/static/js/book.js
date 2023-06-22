const deleteButton = document.getElementById('delete-btn');

if (deleteButton) {
    deleteButton.addEventListener('click', event => {
        let id = document.getElementById('book-id').value;
        fetch(`/api/books/${id}`, {
            method: 'DELETE'
        })
            .then(() => {
                alert('삭제되었습니다.');
                location.replace('/books');
            });
    });
}