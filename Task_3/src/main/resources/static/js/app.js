function addBook() {
    const bookId = $('input[name="bookId"]').val();
    const title = $('input[name="title"]').val();
    const author = $('input[name="author"]').val();

    $.ajax({
        url: '/addBook',
        type: 'POST',
        data: { bookId, title, author },
        success: function(response) {
            refreshBookList();
            $('input[name="bookId"]').val('');
            $('input[name="title"]').val('');
            $('input[name="author"]').val('');
        },
        error: function(xhr) {
            alert('Error adding book: ' + xhr.responseText);
        }
    });
}

function issueBook() {
    const bookId = $('#issueBookId').val();
    const userId = $('#issueUserId').val();

    $.ajax({
        url: '/api/issue',
        type: 'POST',
        data: { bookId, userId },
        success: function(response) {
            $('#issueMessage').text(response);
            refreshBookList();
            $('#issueBookId').val('');
            $('#issueUserId').val('');
        },
        error: function(xhr) {
            $('#issueMessage').text('Error: ' + xhr.responseText);
        }
    });
}

function returnBook() {
    const bookId = $('#returnBookId').val();
    const userId = $('#returnUserId').val();

    $.ajax({
        url: '/api/return',
        type: 'POST',
        data: { bookId, userId },
        success: function(response) {
            $('#returnMessage').text(response);
            refreshBookList();
            $('#returnBookId').val('');
            $('#returnUserId').val('');
        },
        error: function(xhr) {
            $('#returnMessage').text('Error: ' + xhr.responseText);
        }
    });
}
