package com.estsoft.paldotourism.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class)
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseTime{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 댓글 아이디(PK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user; // 댓글 작성자 정보(FK)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Article article; // 게시글 정보(FK)

    @Column
    private String content; // 내용

    @Column
    private Long parent_id;

    @Column
    private Long c_path;

    @Column
    @ColumnDefault("false")
    private Boolean isDeleted;

    @Builder
    public Comment(User user, Article article, String content) {
        this.user = user;
        this.article = article;
        this.content = content;
    }

    public void updateContent(String content){
        this.content = content;
    }
}
