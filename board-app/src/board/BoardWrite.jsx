import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

export default function BoardWrite() {
    const navigate = useNavigate();

    const [title, setTitle] = useState('');
    const [contents, setContents] = useState('');

    const changeTitle = e => setTitle(e.target.value);
    const changeContents = e => setContents(e.target.value);

    const handlerSubmit = e => {
        e.preventDefault();
        axios({
            method: "POST", 
            url: "http://localhost:8080/api/jpa/board", 
            data: {title, contents}, 
        })
        .then(
            res => {
                console.log(res); 
                if (res.status == 200)
                    navigate("/list");
            }
        )
        .catch(err => console.log(err));
    };


    return (
        <>
            <div className="container">
                <h2>게시판 등록</h2>
                <form id="frm" onSubmit={handlerSubmit}>
                    <table className="board_detail">
                        <tbody>
                        <tr>
                        <td>제목</td>
                        <td><input type="text" id="title" name="title" value={title} onChange={changeTitle} /></td>
                        </tr>
                        <tr>
                        <td colSpan="2"><textarea id="contents" name="contents" value={contents} onChange={changeContents}></textarea></td>	               
                        </tr>
                        </tbody>
                    </table>
                    <input type="submit" id="submit" value="저장" className="btn" />
                </form>
            </div>
        </>
    );
}
