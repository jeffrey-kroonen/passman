$(document).ready(() => {
    
    /**
     * Show password entry on card click.
     */
    $(document).on('click', '.password-entry-card-text', (e) => {
        let id = $(e.currentTarget).data('id');

        $.ajax({
            url: `/password-entry-show/${id}`,
            method: 'get',
            success: (form) => {
                $('#password-entry-show').html(form);

                $('#showPasswordEntryModal').modal('show');
            }
        });
    });

    /**
     * Add form row to password entry form.
     */
    $(document).on('click', '#password-entry-field-add-form-row', (e) => {

        let htmlElm = `<div class="row mb-3">
                            <div class="col-sm-4">
                                <label for="">Veldnaam</label>
                                <input type="text" id="" name="passwordEntryFields[]" class="form-control">
                            </div>
                            <div class="col-sm-4">
                                <label for="">Waarde</label>
                                <input type="text" id="" name="passwordEntryValues[]" class="form-control">
                            </div>
                            <div class="col-sm-4">
                                <label for="">Veldtype</label>
                                <select class="form-select" name="passwordEntryTypes[]" id="">
                                    <option value="TEXT">Tekst</option>
                                    <option value="PASSWORD">Wachtwoord</option>
                                </select>
                            </div>
                        </div>`;

        $('#password-entry-field-form-rows').append(htmlElm);
    });

    /**
     * Submit delete user form by pressing delete user button.
     */
    $(document).on('click', '.btn-delete-user', (e) => {
        let id = $(e.currentTarget).data('id');

        if (confirm('Weet je zeker dat je deze gebruiker wilt verwijderen?')) {
            $(`#delete-user-form-${id}`).submit();
        }
    });
});