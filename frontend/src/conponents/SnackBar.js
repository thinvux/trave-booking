import * as React from 'react';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import Snackbar from '@mui/material/Snackbar';
import MuiAlert from '@mui/material/Alert';

const Alert = React.forwardRef(function Alert(props, ref) {
    return <MuiAlert elevation={6} ref={ref} variant="filled" {...props} />;
});

export default function CustomizedSnackbars({ objMsg }) {
    const [open, setOpen] = React.useState(false);

    React.useEffect(() => {
        setOpen(objMsg.openMsg)
    }, [objMsg.openMsg])

    const handleClose = (event, reason) => {
        if (reason === 'clickaway') {
            return;
        }

        setOpen(false);
    };

    return (
        <Snackbar open={open} autoHideDuration={5000} onClose={handleClose} anchorOrigin={{ vertical: 'top', horizontal: 'right' }}>
            <Alert onClose={handleClose} severity={objMsg.statusAlert} sx={{ width: '100%' }}>
                {objMsg.msg}
            </Alert>
        </Snackbar>
    );
}