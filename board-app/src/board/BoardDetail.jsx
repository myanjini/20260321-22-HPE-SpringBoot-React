import axios from "axios";
import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";

export default function BoardDetail() {
    // 상태 변수 정의
    const [board, setBoard] = useState({});

    const [title, setTitle] = useState("");
    const [contents, setContents] = useState("");

    // 경로에 포함된 게시판 반호를 변수에 할당
    const { boardIdx } = useParams();

    const navigate = useNavigate();

    const toListButtonClick = (e) => {
        e.preventDefault();
        navigate("/list");
    };

    const updateButtonClick = e => {
        e.preventDefault();
        axios
            .put(`http://localhost:8080/api/jpa/board/${boardIdx}`, { title, contents })
            .then(res => res && res.status === 200 && navigate("/list"))
            .catch(err => console.log(err));
    };

    const deleteButtonClick = e => {
        e.preventDefault();
        axios
            .delete(`http://localhost:8080/api/jpa/board/${boardIdx}`)
            .then(res => res && res.status === 200 && navigate("/list"))
            .catch(err => console.log(err));
    };


    // 마운트 되었을 때 데이터를 가져와서 상태 변수에 설정
    useEffect(() => {
        axios
            .get(`http://localhost:8080/api/jpa/board/${boardIdx}`)
            .then((res) => {
                console.log(res);
                res && res.data && setBoard(res.data);
                res && res.data && setTitle(res.data.title);
                res && res.data && setContents(res.data.contents);
            })
            .catch((err) => console.log(err));
    }, []);

    return (
        <>
            <div className="container">
                <h2>게시판 상세</h2>
                <table className="board_detail">
                    <colgroup>
                        <col width="15%" />
                        <col width="*" />
                        <col width="15%" />
                        <col width="35%" />
                    </colgroup>
                    <tr>
                        <th>글번호</th>
                        <td>{board.boardIdx}</td>
                        <th>조회수</th>
                        <td>{board.hitCnt}</td>
                    </tr>
                    <tr>
                        <th>작성자</th>
                        <td>{board.createdId}</td>
                        <th>작성일</th>
                        <td>{board.createdDt}</td>
                    </tr>
                    <tr>
                        <th>제목</th>
                        <td colSpan="3">
                            <input
                                type="text"
                                id="title"
                                name="title"
                                value={title} onChange={e => setTitle(e.target.value)}
                                style={{ width: "100%" }}
                            />
                        </td>
                    </tr>
                    <tr>
                        <td colSpan="4">
                            <textarea
                                id="contents"
                                name="contents"
                                value={contents} onChange={e => setContents(e.target.value)}
                                style={{ width: "100%", minHeight: 170 }}
                            ></textarea>
                        </td>
                    </tr>
                </table>
                <input
                    onClick={toListButtonClick}
                    type="button"
                    id="list"
                    className="btn"
                    value="목록으로"
                />
                <input onClick={updateButtonClick} type="button" id="update" className="btn" value="수정하기" />
                <input onClick={deleteButtonClick} type="button" id="delete" className="btn" value="삭제하기" />
            </div>
        </>
    );
}
